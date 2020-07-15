N = int(input())
arr = list(map(int, raw_input().split()))
M = int(input())
q = list(map(int, raw_input().split()))

def solve(target, start, end):
    if start >= end:
        if arr[start] == target:
            return 1
        else:
            return 0

    mid = (start + end) / 2
    if arr[mid] == target:
        return 1
    elif arr[mid] < target:
        return solve(target, mid+1, end)
    else:
        return solve(target, start, mid)
arr = sorted(arr)
for i in q:
    print(solve(i, 0, N-1))

