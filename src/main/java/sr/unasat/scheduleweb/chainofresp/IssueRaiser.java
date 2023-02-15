package sr.unasat.scheduleweb.chainofresp;

public class IssueRaiser {
        public ReceiverInterface setFirstReceiver;

        public IssueRaiser(ReceiverInterface firstReceiver) {
            this.setFirstReceiver = firstReceiver;
        }

        public void raiseMessage(Message msg) {
            if (setFirstReceiver != null) { setFirstReceiver.processMessage(msg); }
        }

}
