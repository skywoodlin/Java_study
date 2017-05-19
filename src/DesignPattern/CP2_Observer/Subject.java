package DesignPattern.CP2_Observer;


/**
 * Created by xjlin on 2017/3/16.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
