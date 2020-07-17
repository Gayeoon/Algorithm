self_num = set(range(1, 10001))
noSelf_num = set()

for i in range(1, 10001):
    num = i
    for j in str(i):
        num += int(j)
    noSelf_num.add(num)

self_num = self_num - noSelf_num

for i in sorted(self_num):
    print(i)