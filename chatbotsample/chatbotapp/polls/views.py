from django.contrib.auth import authenticate
from django.http import JsonResponse
from django.shortcuts import render

# Create your views here.
from django.views.decorators.csrf import csrf_exempt


@csrf_exempt
def app_msg(request):
    from chatbot.utils.Preprocess import Preprocess
    from chatbot.models.intent.IntentModel import IntentModel
    from chatbot.utils.FindAnswer import FindAnswer

    if request.method == 'POST':
        msg = request.POST.get('msg','')
        print(msg)

        # 전처리 객체 생성
        p = Preprocess(word2index_dic="chatbotapp/polls/chatbot/train_tools/dict/chatbot_dict.bin",
                       userdic="chatbotapp/polls/chatbot/train_tools/dict/NIADIc2Komoran.txt")

        # 사용자 문장
        query = msg

        # 의도 파악
        intent = IntentModel(model_name="chatbotapp/polls/chatbot/models/intent/intent_model.h5", proprocess=p)
        predict = intent.predict_class(query)
        intent_name = intent.labels[predict]
        """
        print("질문 : ", query)
        print("=" * 40)
        print("의도 파악 : ", intent_name)

        print("=" * 40)
        """
        # 챗봇 답변

        f = FindAnswer("chatbotapp/polls/chatbot/utils/answer_list.csv")
        answer = f.search(intent=intent_name)
        print("answer : ", answer)

        return JsonResponse({'msgg': answer}, status=200)