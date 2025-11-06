K, L = map(int, input().split())

arr = [] 
student_dict = {}

for i in range(L):
    student_id = input().strip()
    student_dict[student_id] = i
    arr.append(student_id)
result = []
count = 0

for i in range(L):
    student_id = arr[i]
    
    
    if student_dict[student_id] == i:
        result.append(student_id)
        count += 1
        if count == K:
            break

for student_id in result:
    print(student_id)