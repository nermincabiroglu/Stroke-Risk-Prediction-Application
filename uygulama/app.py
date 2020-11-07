from os.path import join, dirname
import pandas as pd
import warnings

warnings.filterwarnings('ignore')

from sklearn.model_selection import StratifiedKFold
from keras.models import Sequential
from keras.layers import Conv1D, GlobalMaxPooling1D
from keras.layers import Embedding
from keras.layers import Dense, Dropout
from keras.layers import Dense, Activation
import numpy as np

class strokeLearning():

    def __init__(self):
        self.filename = join(dirname(__file__), "D1.csv")
        self.data = pd.read_csv(self.filename)
        self.max_features = 5000
        self.maxlen = 400
        self.batch_size = 32
        self.embedding_dims = 50
        self.filters = 250
        self.kernel_size = 3
        self.hidden_dims = 250


        self.y = self.data["stroke"]
        self.x = self.data.drop(["stroke"], axis=1)
        self.skf = StratifiedKFold(n_splits=3)
        self.model=None



    def train_model(self):


        x=self.x
        y=self.y

        max_features=self.max_features
        embedding_dims=self.embedding_dims
        filters=self.filters
        kernel_size=self.kernel_size
        hidden_dims=self.hidden_dims

        for train_index, test_index in self.skf.split(x, y):
            x_train, x_test = x.loc[train_index], x.loc[test_index]
            y_train, y_test = y[train_index], y[test_index]
            model = Sequential()
            model.add(Embedding(max_features,  # max_features=5000 (it isn't important)
                                embedding_dims,  # embedding_dims=50
                                input_length=10))  # length x.shape[0]

            model.add(Dropout(0.2))
            # we add a Convolution1D, which will learn filters
            # word group filters of size filter_length:
            model.add(Conv1D(filters,
                             kernel_size,
                             padding='valid',
                             activation='relu',
                             strides=1))
            # we use max pooling:
            model.add(GlobalMaxPooling1D())

            # We add a vanilla hidden layer:
            model.add(Dense(hidden_dims))  # hidden_dims=250
            model.add(Dropout(0.2))
            model.add(Activation('relu'))

            # We project onto a single unit output layer, and squash it with a sigmoid:
            model.add(Dense(1))
            model.add(Activation('sigmoid'))

            model.compile(loss='binary_crossentropy',
                          optimizer='adam',
                          metrics=['accuracy'])

            model.fit(x_train, y_train,  #  train data
                      batch_size=128,  # batch_size=32
                      epochs=10,
                      verbose=1,
                      validation_data=(x_test, y_test))  # test data
        self.model=model


        return model


    def prediction(self,cinsiyet,yas,hipertansiyon,kalp,evlenme,isSekli,yasayıssekli,seker,sigara,boy,kilo):
        """

        :param a0: cinsiyet 0:kadın 1:erkek 2:  diger
        :param a1: yas
        :param a2: hipertansiyon 0:yok 1:var
        :param a3: kalp hastaligi 0:yok 1:var
        :param a4: hic evlenmis mi 1:evlenmis 0:evlenmemis
        :param a5: calisma sekli 0:cocuk 1: politika 2:hic 3: özel 4: kendiIsi
        :param a6: yasayis sekli 0:kırsal 1 :kentsel
        :param a7: seker seviyesi (yemek yedikten sonra ölcülmeli)
        :param a8: vücut kitle indeksi /2
        :param a9: sigara 0: önceden icmis 1: hic icmemis 2: iciyor
        :return:
        """
        boy=boy/100

        bmi=(kilo/(boy*boy))/1.3

        arr=np.array([cinsiyet,yas,hipertansiyon,kalp,evlenme,isSekli,yasayıssekli,seker,bmi,sigara])
        pred=self.model.predict_classes([[arr]])
        print(pred[0,0])

        print("cinsiyet: ",cinsiyet)
        print("yas: ",yas)
        print("hipertansiyon: ",hipertansiyon)
        print("kalp rahatsılıgı: ", kalp)
        print("evlenme: ",evlenme)
        print("isSekli: ", isSekli )
        print("yasayıs: ",yasayıssekli )
        print("seker: ", seker)
        print("bmi: ",bmi)
        print("smoke: ",sigara)
        return pred[0,0]









sl=strokeLearning()

def trainModel():
    sl.train_model()

def prediction(cinsiyet,yas,hipertansiyon,kalp,evlenme,isSekli,yasayıssekli,seker,sigara,boy,kilo):
    sl.prediction(cinsiyet,yas,hipertansiyon,kalp,evlenme,isSekli,yasayıssekli,seker,sigara,boy,kilo)

