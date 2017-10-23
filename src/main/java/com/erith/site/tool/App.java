package com.erith.site.tool;

import us.codecraft.webmagic.Spider;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").thread(5).run();
    }
}
