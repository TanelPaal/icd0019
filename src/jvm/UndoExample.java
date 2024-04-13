package jvm;

import java.util.Stack;

public class UndoExample {

    public static void main(String[] args) {
        Stack<Runnable> undoSteps = new Stack<>();

        // ... do action A
        undoSteps.push(new MyUndoAction("reverse action for A"));
        // ... do action B
        undoSteps.push(new MyUndoAction("reverse action for B"));
        // ...

        // undo last action
        undoSteps.pop().run();
    }

    static class MyUndoAction implements Runnable {
        @Override
        public void run() {
            // execute the action
        }

        public MyUndoAction(String input) {
        }
    }

}
