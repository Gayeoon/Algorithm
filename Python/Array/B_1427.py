s = raw_input()
n = []
for i in s:
    n.append(i)
n.sort(reverse=True)
print("".join(n))