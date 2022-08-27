"""
형태소 분석 및 전처리 클래스 정의
"userdic" parameter에는 사용자 정의 사전 파일의 경로 입력
사용하지 않을 품사는 불용어 리스트에 집어 넣고
komoran 형태소 분석기 객체를 직접적으로 호출하지 않기 위해 pos 함수 정의
불용어 제거후 핵심 키워드 정보만 가져오기 위해 get_keyword 함수 정의
"""


from konlpy.tag import Komoran
import pickle


class Preprocess:
	def __init__(self, word2index_dic='', userdic=None):  # 생성자
		#단어 인덱스 사전 불러오기
		if word2index_dic != '':
			f = open(word2index_dic, "rb")
			self.word_index = pickle.load(f)
			f.close()
		else:
			self.word_index = None

		# 형태소 분석기 초기화
		self.komoran = Komoran(userdic=userdic)

		# 제외할 품사(불용어)
		# 참조 : https://docs.komoran.kr/firststep/postypes.html
		self.exclusion_tags = [
			"JKS", "JKC", "JKG", "JKO", "JKB", "JKQ", "JX", "JC",   # 관계언 제거
			"SF", "SP", "SS", "SE", "SO",                           # 기호 제거
			"EP", "EF", "EC", "ETN", "ETM",                         # 어미 제거
			"XSN", "XSV", "XSA"                                     # 접미사 제거
		]

	# 형태소 분석기 POS 태거
	def pos(self, sentence):
		return self.komoran.pos(sentence)
		# 문장을 잘게 나눠서 품사를 태그 패깅된 품사는 형태소와 함께 리스트 형태로 반환
		# Ex) [("아버지", "NNG"), ("가", "JKS") ... ]

	# 불용어 제거 후 필요한 품사 정보만 가져오기
	def get_keywords(self, pos, without_tag=False):
		f = lambda x: x in self.exclusion_tags
		word_list = []
		for p in pos:
			if f(p[1]) is False:
				word_list.append(p if without_tag is False else p[0])
		return word_list

	# 키워드를 단어 인덱스 시퀀스로 변환
	def get_wordidx_sequence(self, keywords):
		w2i = []

		if self.word_index is None:
			return w2i

		for word in keywords:
			try:
				w2i.append(self.word_index[word])
			except KeyError:
				# 해당 단어가 사전에 없는 경우 OOV 처리(OOV == 미등록어)
				w2i.append(self.word_index["OOV"])
		return w2i
