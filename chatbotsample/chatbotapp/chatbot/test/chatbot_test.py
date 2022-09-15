from utils.Preprocess import Preprocess

# 전처리 객체 생성
p = Preprocess(word2index_dic="../train_tools/dict/chatbot_dict.bin", userdic="../train_tools/dict/NIADIc2Komoran.txt")

# 테스트 원문
query = "이번에 본 컴퓨터 자격증 시험에 합격해서 너무 기뻐"

# 의도 파악
from models.intent.IntentModel import IntentModel

intent = IntentModel(model_name="../models/intent/intent_model.h5", proprocess=p)
predict = intent.predict_class(query)
intent_name = intent.labels[predict]


print("질문 : ", query)
print("=" * 40)
print("의도 파악 : ", intent_name)

print("=" * 40)

from utils.FindAnswer import FindAnswer

f = FindAnswer("../utils/answer_list.csv")
answer = f.search(intent=intent_name)
print("answer : ", answer)
