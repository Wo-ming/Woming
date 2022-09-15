import pandas as pd
import random

class FindAnswer:
	def __init__(self, filename):
		data = pd.read_csv(filename, delimiter=',', low_memory=False)
		answer = data["answer"].tolist()
		intents = data["intent"].tolist()
		self.dict = {}
		for idx in range(len(answer)):
			if intents[idx] not in list(self.dict.keys()):
				self.dict[intents[idx]] = [answer[idx]]
			else:
				answer_list = self.dict[intents[idx]]
				answer_list.append(answer[idx])
				self.dict[intents[idx]] = answer_list

	# 답변 검색
	def search(self, intent):
		# 의도명으로 답변 검색
		answer_list = self.dict[intent]
		answer = answer_list[random.randint(0, len(answer_list) - 1)]

		return answer
