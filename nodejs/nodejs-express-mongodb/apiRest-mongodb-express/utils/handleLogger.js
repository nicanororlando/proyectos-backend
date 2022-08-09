const { IncomingWebhook } = require("@slack/webhook");

const webHook = new IncomingWebhook(process.env.SLACK_WEBHOOK);

const loggerStream = {
  write: (message) => {
    // Para enviar el mensaje de error a nuestro slack.
    webHook.send({
      text: message,
    });
  },
};

module.exports = loggerStream;
