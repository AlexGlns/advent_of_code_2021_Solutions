#############################
#                           #
#   advnetofcode 2021 - 3   #
#                           #
#############################

from random import seed
from random import randint

#seed(1)

# compute gamma_rate #

def gamma_rate(diagnosis):
    gamma_rt=''
    counter1=0              
    counter0=0                          
    for i in range(5):
        for bitnum in diagnosis:
            _bit_=bitnum[i]
            if _bit_=='1':
                counter1+=1
            else:
                counter0+=1
        
        if counter1>counter0:
            gamma_rt=gamma_rt+'1'
        else:
            gamma_rt=gamma_rt+'0'

        counter0=0
        counter1=0

    return gamma_rt

# compute epsilon_rate #

def epsilon_rate(gamma_rt):
    epsilon_rt=''
    for _bit_ in gamma_rt:
        if _bit_=='1':
            epsilon_rt=epsilon_rt + '0'
        else:
            epsilon_rt=epsilon_rt + '1'


    return epsilon_rt

#########################

diagnosticrep=list()

for i in range(11):
    str_num=''
    for j in range(5):
        value=randint(0,1)
        str_num=str_num + str(value)

    diagnosticrep.append(str_num)

for x in diagnosticrep:
    print(x)

print()
print("gamma rate in binary == " + gamma_rate(diagnosticrep))
print("epsilon rate in binary == " + epsilon_rate(gamma_rate(diagnosticrep)))

gamma_rt=gamma_rate(diagnosticrep)
eps_rt=epsilon_rate(gamma_rt)

gm_rt=0
e_rt=0

i=4

for _bit_ in gamma_rt:
    if _bit_ == '1':
        gm_rt= gm_rt + 2**i
    i=i-1

i=4
for _bit_ in eps_rt:
    if _bit_ == '1':
        e_rt=e_rt+ 2**i
    i=i-1

print()
print("gamma rate in demical == " + str(gm_rt))
print("epsilon rate in binary == "+ str(e_rt))
print()

print("Power Consumption : " + str(gm_rt) + " * " + str(e_rt) + " = " + str(gm_rt * e_rt))