package com.DijkstraInterpreter;

import java.util.Stack;

public class Algorithm {

    private Stack<String> operationsStack;
    private Stack<Double> valuesStack;

    Algorithm() {
        this.operationsStack = new Stack<>();
        this.valuesStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        String[] expressionArray = expression.split(" ");

        for (String s : expressionArray) {
            if (s.equals("(")) {

            } else if (s.equals("+")) {
                this.operationsStack.push(s);
            } else if (s.equals("*")) {
                this.operationsStack.push(s);
            } else if (s.equals(")")) {
                String operation = this.operationsStack.pop();
                if (operation.equals("+")) {
                    this.valuesStack.push(this.valuesStack.pop() + this.valuesStack.pop());
                } else if (operation.equals("*")) {
                    this.valuesStack.push(this.valuesStack.pop() * this.valuesStack.pop());
                }
            } else {
                this.valuesStack.push(Double.parseDouble(s));
            }
        }
    }

    public void result() {
        System.out.println(this.valuesStack.pop());
    }
}
