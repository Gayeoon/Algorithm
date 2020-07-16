def push(num):
    stack.append(num)

def peek():
    if empty() == 1:
        print(-1)
    else:
        print(stack[-1])

def pop():
    if empty() == 1:
        print(-1)
    else:
        print(stack.pop())

def size():
    print(len(stack))

def empty():
    if len(stack) == 0:
        return 1
    else:
        return 0

n = int(input())
stack = []
for i in range(0, n):
    order = []
    order = raw_input().split()
    if order[0] == 'push':
        push(int(order[1]))
    elif order[0] == 'top':
        peek()
    elif order[0] == "pop":
        pop()
    elif order[0] == "size":
        size()
    elif order[0] == "empty":
        print(empty())
