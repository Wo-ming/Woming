from django.urls import path

from . import views
from . import chatbot


urlpatterns=[
    path('app_msg/', views.app_msg),


]

