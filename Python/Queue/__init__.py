from collections import deque

q = deque()
n, k = map(int, raw_input().split())
for i in range(1, n+1):
    q.append(i)

cnt = 0
s = "<"
while True:
    if len(q) == 1:
        s += str(q.pop())
        break
    cnt += 1
    if cnt == k:
        s += str(q.popleft()) +", "
        cnt = 0
    else:
        tmp = q.popleft()
        q.append(tmp)

print s+ ">"
