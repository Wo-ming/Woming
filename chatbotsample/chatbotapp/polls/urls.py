from django.urls import path

from . import views


urlpatterns=[
    path('app_msg/', views.app_msg)

]

