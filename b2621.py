arr = []
colorSet = set()
score = 0
numberDict = {}

for i in range(5):
  color, number = input().split()
  number = int(number)

  if number not in numberDict:
    numberDict[number] = []
  numberDict[number].append(color)
  arr.append({"color": color, "number": number})
  colorSet.add(color)
 

sortedArray = sorted(arr, key=lambda x: x['number'])

isSorted = True
for i in range(4):
  if sortedArray[i+1]["number"] - sortedArray[i]["number"] != 1:
    isSorted = False


if len(colorSet) == 1 and isSorted:
  score = sortedArray[4]["number"] + 900

for number in numberDict:
  if len(numberDict[number]) == 4:
    score = max(score, int(number) + 800)


if len(numberDict) == 2:
  tmp = 0
  for number in numberDict:
    if len(numberDict[number]) == 3:
      tmp += int(number)*10
    else:
      tmp += int(number)
    score = max(score, tmp + 700)

if len(colorSet) == 1:
  score = max(score, sortedArray[4]["number"] + 600)


if isSorted:
  score = max(score, sortedArray[4]["number"] + 500)

for num in numberDict:
  if len(numberDict[num]) == 3:
    score = max(score, int(num) + 400)

if len(numberDict) == 3:
  tmpMax = 0
  tmpMin = 10
  for num in numberDict:
    if len(numberDict[num]) == 2:
      tmpMax = max(num, tmpMax)
      tmpMin = min(num, tmpMin)
  
  score = max(score, tmpMax * 10 + tmpMin + 300)

if len(numberDict) == 4:
  for num in numberDict:
    if len(numberDict[num]) == 2:
      score = max(score, int(num) + 200) 

if score == 0:
  score = 100 + sortedArray[4]["number"]

print(score)