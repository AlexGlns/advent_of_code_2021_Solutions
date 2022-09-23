#############################
#                           #
#   advnetofcode 2021 - 3   #
#                           #
#############################

from random import seed
from random import randint

HorizonPositions=list()

for i in range(10):
    HorizonPositions.append(randint(0,20))

print(HorizonPositions)
print()
Distance=list()

for i in HorizonPositions:
    sum=0
    for j in HorizonPositions:
        sum=sum+(abs(i-j))
    Distance.append(sum)

index=0
min=1000000
for i in Distance:
    if (i<min):
        min=i
        index=Distance.index(i)
print(Distance)
print("Crasbs can align to ", HorizonPositions[index])
print("Total cost of feul : ", min)