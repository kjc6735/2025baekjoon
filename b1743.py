from collections import deque

N,M,K = map(int, input().split())
dir = [[0,1], [1,0], [0,-1], [-1,0]]

def inRange(x,y):
  return x <= N and x >= 1 and y <= M and y >= 1

arr = [[0 for _ in range(101)] for _ in range(101)]

for i in range(0, K):
  x,y = map(int, input().split())
  arr[x][y] = 1

max = 0

for i in range(1, N+1):
  for k in range(1, M+1):
    cnt = 0
    if arr[i][k] == 1:
      arr[i][k] = 0
      cnt+=1
      queue = deque()
      queue.append([i,k])
      while len(queue) != 0:
        curr = queue.popleft()
        for d in dir:
          dx = curr[0] + d[0]
          dy = curr[1] + d[1]
          if inRange(dx,dy) and arr[dx][dy] == 1:
            arr[dx][dy] = 0
            queue.append([dx,dy])
            cnt+=1
    if max < cnt:
      max = cnt
print(max)