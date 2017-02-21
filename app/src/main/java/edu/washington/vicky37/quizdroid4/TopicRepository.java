package edu.washington.vicky37.quizdroid4;

import java.util.ArrayList;

/**
 * Created by victoriajuan on 2/13/17.
 */

public interface TopicRepository {

    public Topic getTopic(String string);

    public void addTopic(Topic t);

    public void replaceTopic(int i, Topic topic);

    public void setTopic(String string);

    public String getShortDesc(String string);

    public String getLongDesc();


}
