package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("[.]", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }


    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        try {
            Document document = getDocument();
            Elements template = document.getElementsByClass("template");
            Element clearTemplate = template.clone().removeAttr("style").removeClass("template").get(0);
            for (Element vacancy : document.getElementsByClass("vacancy")) {
                if (!vacancy.hasClass("template")) vacancy.remove();
            }

            for (Vacancy vacancy : vacancies) {
                Element vacancyTemplate = clearTemplate.clone();
                vacancyTemplate
                        .getElementsByClass("city")
                        .get(0)
                        .appendText(vacancy.getCity());
                vacancyTemplate
                        .getElementsByClass("companyName")
                        .get(0)
                        .appendText(vacancy.getCompanyName());
                vacancyTemplate
                        .getElementsByClass("salary")
                        .get(0)
                        .appendText(vacancy.getSalary());
                vacancyTemplate.getElementsByClass("title")
                        .get(0)
                        .appendText(vacancy.getTitle())
                        .attr("href", vacancy.getUrl());
                template.before(vacancyTemplate.outerHtml());
            }
            return document.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String content) {
        File file = new File(filePath);
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("odessa");
    }
}
