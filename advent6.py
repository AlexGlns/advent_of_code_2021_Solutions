#############################
#                           #
#   advnetofcode 2021 - 6   #
#                           #
#############################

lanternfish=list()

lanternfish=[3,4,3,1,2]         #Input

print("Initial state: " , lanternfish)

add=False
indexAdd=list()         #Store index where reamains o days to produce fish

for i in range(80):
    index=0
    for fish in lanternfish:
        if (fish>0):
            lanternfish[index]=lanternfish[index]-1
        else:
            lanternfish[index]=6
            lanternfish.append(9)
        index=index+1
    print("After ",i+1," day: ",lanternfish)

print()
print("Number of fishes after 80 days : ",len(lanternfish))



    


