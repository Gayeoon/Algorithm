n = int(input())
list = []
for i in range(0, n):
    r, st = raw_input().split()
    answer = ""
    for s in str(st):
        for j in range(0, int(r)):
           answer += s
    list.append(answer)

for s in list:
    print(s)
