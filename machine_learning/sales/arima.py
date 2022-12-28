# -*- coding: utf-8 -*-
import random

import pandas as pd
import sys
from statsmodels.tsa.arima_model import ARIMA

import warnings
import datetime

warnings.filterwarnings("ignore")

args = sys.argv
args.pop(0)
dates = []
nums = []
if len(args) != 0:
    for i in range(len(args)):
        if i % 2 == 0:
            date = datetime.date(*map(int, args[i].split('-')))
            dates.append(date)
        else:
            nums.append(i)
else:
    for i in range(110):
        dates.append(datetime.date.today() + datetime.timedelta(days=i))
        nums.append(random.randint(100, 200))

dates = pd.DatetimeIndex(dates)
data = pd.DataFrame({"nums": nums}, index=dates)

# 对数据进行差分（求相邻的Δ）后得到 自相关图和 偏相关图
D_data = data.diff().dropna()
D_data.columns = [u'销量差分']

# 对模型进行定阶
pmax = int(len(D_data) / 10)  # 一般阶数不超过 length /10
qmax = int(len(D_data) / 10)
pmax = min(3, pmax)
qmax = min(3, qmax)
print(pmax, qmax)
bic_matrix = []
for p in range(pmax + 1):
    temp = []
    for q in range(qmax + 1):
        try:
            value = ARIMA(D_data, (p, 1, q), freq='D').fit().bic  # freq=MS为默认的，不加则模型会自动添加并报warning
            temp.append(value)
        except:
            temp.append(None)
        bic_matrix.append(temp)

bic_matrix = pd.DataFrame(bic_matrix)  # 将其转换成Dataframe 数据结构
print(bic_matrix)
p, q = bic_matrix.stack().idxmin()  # 先使用stack 展平， 然后使用 idxmin 找出最小值的位置

# 建立ARIMA 模型

model = ARIMA(data, (p, 1, q), freq='D').fit()

predictions=model.forecast(5)
pre_result = predictions[0]
print(pre_result)


# model.summary2()
# # 保存模型
# model.save('model.pkl')
# # 模型加载
# from statsmodels.tsa.arima_model import ARIMAResults
#
# loaded = ARIMAResults.load('model.pkl')
# # 预测未来五个单位
# predictions = loaded.forecast(5)
# # 预测结果为：
# pre_result = predictions[0]
# print(pre_result)
