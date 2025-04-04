
n = int(input())
idx = n-1
t = 0
check = True
for i in range(0,2*n-1):
  for k in range(0, idx+t+1):
    if k in list(range(idx -t,idx+t+1)):
      print("*", end="")
    else:
      print(" ", end="")
  if i != 2*n-1:
    print()
  if idx - t == 0:    
    check = False
  if check == False:
    t-=1
  else:
    t += 1
