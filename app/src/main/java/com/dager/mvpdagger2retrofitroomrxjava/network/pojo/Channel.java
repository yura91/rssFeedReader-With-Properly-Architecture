package com.dager.mvpdagger2retrofitroomrxjava.network.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

import java.util.ArrayList;

public class Channel
{
    private String pubDate;

    @Element(name = "title", required = true )
    private String title;

    private String managingEditor;

    private String description;

    @Path("link")
    @Text(required=false)
    private String link;

    private String lastBuildDate;

    @ElementList(name = "item", required = true, inline = true)
    private ArrayList<Item> item;

    private String generator;

    private Image image;

    private String language;

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

    public String getManagingEditor ()
    {
        return managingEditor;
    }

    public void setManagingEditor (String managingEditor)
    {
        this.managingEditor = managingEditor;
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

    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public ArrayList<Item> getItem ()
    {
        return item;
    }

    public void setItem (ArrayList<Item> item)
    {
        this.item = item;
    }

    public String getGenerator ()
    {
        return generator;
    }

    public void setGenerator (String generator)
    {
        this.generator = generator;
    }

    public Image getImage ()
    {
        return image;
    }

    public void setImage (Image image)
    {
        this.image = image;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pubDate = "+pubDate+", title = "+title+", managingEditor = "+managingEditor+", description = "+description+", link = "+link+", lastBuildDate = "+lastBuildDate+", item = "+item+", generator = "+generator+", image = "+image+", language = "+language+"]";
    }
}
