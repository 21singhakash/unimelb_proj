from flask import Flask, request, Response
from botbuilder.schema import Activity #activity from schema for converting json to activity
from botbuilder.core import (
    BotFrameworkAdapter,
    BotFrameworkAdapterSettings)
    
import asyncio
from bot import QnABot

app = Flask(__name__)
loop = asyncio.get_event_loop() # this loop runs until complete the task

botadaptersettings = BotFrameworkAdapterSettings("","") #app Id "" & app apssword ""
botadapter = BotFrameworkAdapter(botadaptersettings)

qna_bot = QnABot()

@app.route("/api/messages",methods=["POST"])
def messages():
    if "application/json" in request.headers["content-type"]: #checking request header for json format
        jsonmessage = request.json #reading json message
    else:
        return Response(status=415)

    activity = Activity().deserialize(jsonmessage) #creating activity object from jsonmessage

    async def turn_call(turn_context):
        await qna_bot.on_message_activity(turn_context)
    
    #botadapter.process_activity(activity,"",turn_call) 
    #passing the activity to adapter to get TurnContext(passed to bot) obj using process_activity method
    task = loop.create_task(botadapter.process_activity(activity,"",turn_call))
    loop.run_until_complete(task) #loop will run until task is complete

    return ""

if __name__ == '__main__':
    app.run('localhost',3978)