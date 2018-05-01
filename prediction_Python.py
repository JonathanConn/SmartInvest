import matplotlib
matplotlib.use('TkAgg')

from numpy import arange, sin, pi
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg, NavigationToolbar2TkAgg
from matplotlib.backend_bases import key_press_handler

import quandl
import pandas as pd
import numpy as np
import datetime
import matplotlib.pyplot as plt


from sklearn.linear_model import LinearRegression
from sklearn import preprocessing, cross_validation, svm
from sklearn import datasets, linear_model

from matplotlib.figure import Figure

import sys
if sys.version_info[0] < 3:
    import Tkinter as Tk
else:
    import tkinter as Tk

def _quit():
    root.quit() 
    root.destroy()  

def runPred():
    global e
    global f
    global i

    interval = i.get()
    string = e.get() 
    print string
    print ("Predicting WIKI/"+string)
    
    df = quandl.get("WIKI/"+string)
    df = df[['Adj. Close']]
    forecast_out = int(interval)
    df['Prediction'] = df[['Adj. Close']].shift(-forecast_out)

    X = np.array(df.drop(['Prediction'],1))
    X = preprocessing.scale(X)

    X_forecast = X[-forecast_out:]
    X = X[:-forecast_out]

    y = np.array(df['Prediction'])
    y = y[:-forecast_out]

    X_train, X_test, y_train, y_test = cross_validation.train_test_split(X, y, test_size = 0.2)

    clf = LinearRegression()
    clf.fit(X_train,y_train)

    confidence = clf.score(X_test, y_test)

    forecast_prediction = clf.predict(X_forecast)
    print(forecast_prediction)
    a = f.add_subplot(111)
    a.set_title('Symbol '+string)
    a.set_xlabel('Time (Days)')
    a.set_ylabel('Value ($)')
    
    a.plot(forecast_prediction)
    
    canvas.show()
    f.clear()



matplotlib.use("TkAgg")
quandl.ApiConfig.api_key = "_uUxBUKLpJA6qaSwk5mx"

root = Tk.Tk()
root.wm_title("Smart Stock")

f = Figure(figsize=(6, 5), dpi=100)

canvas = FigureCanvasTkAgg(f, master=root)
canvas.show()
canvas.get_tk_widget().pack(side=Tk.TOP, fill=Tk.BOTH, expand=1)

toolbar = NavigationToolbar2TkAgg(canvas, root)
toolbar.update()
canvas._tkcanvas.pack(side=Tk.TOP, fill=Tk.BOTH, expand=1)



text1 = Tk.Label(master=root, text="Stock Symbol")
text1.pack()

e = Tk.Entry(master=root)
e.pack()
e.focus_set()

text1 = Tk.Label(master=root, text="Interval (Days)")
text1.pack()

i = Tk.Entry(master=root)
i.pack()
e.focus_set()

button = Tk.Button(master=root, text='Predict', command=runPred)
button.pack(side=Tk.BOTTOM)

Tk.mainloop()
