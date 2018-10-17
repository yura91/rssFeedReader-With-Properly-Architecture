package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Rss
{
    @Element
    private Channel channel;
    @Attribute
    private String version;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+", version = "+version+"]";
    }
}
