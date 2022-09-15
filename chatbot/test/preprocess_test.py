from utils.Preprocess import  Preprocess

sent = "본국의 가족에게 보내는 송금 총액은 매년 100억 달러를 넘어 필리핀 경제를 지탱하고 가족들을 먹여 살린다."

#전처리 객체 생성
p = Preprocess(userdic="../train_tools/dict/userdic.txt")

#형태소 분석기 실행
pos = p.pos(sent)

# 품사 태그와 같이 키워드 출력
ret = p.get_keywords(pos, without_tag=False)
print(ret)

# 품사 태그 없이 키워드 출력
ret = p.get_keywords(pos, without_tag=True)
print(ret)