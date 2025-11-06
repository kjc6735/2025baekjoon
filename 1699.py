N = input()

dp = [1] * N+1
for n in range(1, N+1):
  add = n * n # n^2
  for k in range(add, N+1):
    dp[k] = min(dp[k], )
