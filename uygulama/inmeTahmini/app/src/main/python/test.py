import keras
import numpy as np
from os.path import join, dirname

import warnings

warnings.filterwarnings('ignore')



mypath= join(dirname(__file__), "strokeModel.pb")


loadedModel=keras.models.load_model(mypath)


#arr=np.array([1,45,0,0,1,3,1,224.10,56.60,1])

#pred=loadedModel.predict_classes([[arr]])





def prediction(cinsiyet, yas, hipertansiyon, kalp, evlenme, isSekli, yasayissekli, seker, sigara, boy, kilo):

    boy = boy / 100

    bmi = (kilo / (boy * boy))/1.3
    print(bmi)
    arr = np.array([cinsiyet, yas, hipertansiyon, kalp, evlenme, isSekli, yasayissekli, seker, bmi, sigara])
    pred = loadedModel.predict_classes([[arr]])
    print(pred[0, 0])
    return pred[0, 0]


