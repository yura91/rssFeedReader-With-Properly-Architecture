package com.dager.mvpdagger2retrofitroomrxjava.network.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "item", strict = false)
public class Item
{
    @Embedded
    private Guid guid;

    @Element(name = "pubDate", required = true )
    private String pubDate;

    @Element(name = "title", required = true )
    private String title;

    private String[] category;

    @Element(name = "description", required = true )
    private String description;

    @Element(name = "link", required = true )
    private String link;

    public Guid getGuid ()
    {
        return guid;
    }

    public void setGuid (Guid guid)
    {
        this.guid = guid;
    }

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String[] getCategory ()
    {
        return category;
    }

    public void setCategory (String[] category)
    {
        this.category = category;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [guid = "+guid+", pubDate = "+pubDate+", title = "+title+", category = "+category+", description = "+description+", link = "+link+"]";
    }
}
