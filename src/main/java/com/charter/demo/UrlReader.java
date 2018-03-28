package com.charter.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.util.Arrays;

public class UrlReader {
    private static final String[] SUPPORTED_SITES = new String[]{"xiachufang.com"};

    public void readPage() throws Exception {
        String url = "https://www.xiachufang.com/recipe/100114107/";

        URI uri = new URI(url);
        String domain = uri.getHost();
        String domainName = domain.startsWith("www.") ? domain.substring(4) : domain;

        System.out.println("Domain name: " + domainName);

        if(!Arrays.asList(SUPPORTED_SITES).contains(domainName)) {
            System.err.println("This site is not supported.");
            return;
        }

        Document doc = Jsoup.connect(url).get();

        Element recipeName = doc.selectFirst(".page-title");
        Element recipeRating = doc.selectFirst(".recipe-show .stats span[itemprop = ratingValue]");
        System.out.println("Recipe Name: " + recipeName.text() + " (Rating = " + recipeRating.text() + ")");

        System.out.println("Steps: ");
        Elements recipeSteps = doc.selectFirst(".steps").select("li");

        for(int i = 0; i < recipeSteps.size(); i++) {
            System.out.println("step " + (i + 1) + ": " + recipeSteps.get(i).text());
        }

        System.out.println("==================================");
//        System.out.println(doc.body());
    }
}
