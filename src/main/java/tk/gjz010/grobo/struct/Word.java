/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.grobo.struct;

import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Word implements Comparable{
    public Word(int priority){
        this.priority=priority;
    }
    private int priority;
    private String[] args;
    private String message;
    public int getPriority(){
        return priority;
    }
    @Override
    public int compareTo(Object o) {
        Word w=(Word)o;
        if(getPriority()>w.getPriority()){
            return 1;
        }
        if(getPriority()<w.getPriority()){
            return -1;
        }
        return new Random().nextInt(2);
    }


    public String[] getArgs() {
        return args;
    }

    public String getMessage() {
        return message;
    }
}