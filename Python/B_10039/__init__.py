sum = 0
for i in range (1, 6) :
    tmp = int(input())
    if tmp < 40:
        sum += 40
    else:
        sum += tmp

print("%d" %(sum / 5))