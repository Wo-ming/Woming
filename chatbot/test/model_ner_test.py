from utils.Preprocess import Preprocess
from models.ner.NerModel import NerModel

p = Preprocess(word2index_dic="../train_tools/dict/chatbot_dict.bin", userdic="../utils/user_dic.tsv")

ner = NerModel(model_name="../models/ner/ner_model.h5", proprocess=p)
query = "12월에 열리는 월드컵에서 내가 할 일은 없을까?."
predicts = ner.predict(query)
print(predicts)


"""
인물(PER)
학문분야(FLD)
인공물(AFW)
기관 및 단체(ORG)
지역명(LOC)
문명 및 문화(CVL)
날짜(DAT)
시간(TIM)
숫자(NUM)
사건 사고 및 행사(EVT)
동물(ANM)
식물(PLT)
금속/암석/화학물질(MAT)
의학용어/IT관련 용어(TRM)

"""