def solution(survey, choices):
    answer = ''
    dic = {i : 0 for i in "RTCFJMAN"}
    chr = ["RT", "CF", "JM", "AN"]
    score = {1:3,2:2,3:1,4:0,5:1,6:2,7:3}
    for i in range(len(survey)):
        key1, key2 = list(survey[i])
        num = choices[i]
        if num <= 3:
            if key1 in dic:
                dic[key1] += score[num]
            else:
                dic[key1] = score[num]
        elif num == 4:
            pass
        else:
            if key2 in dic:
                dic[key2] += score[num]
            else:
                dic[key2] += score[num]
    for str1, str2 in list(chr):
        v1, v2 = dic[str1], dic[str2]
        if v1 > v2:
            answer += str1
        elif v1 == v2:
            if ord(str1) < ord(str2):
                answer += str1
            else:
                answer += str2
        else:
            answer += str2
    return answer

print(solution(["AN", "CF", "MJ", "RT", "NA"],[5, 3, 2, 7, 5]))
