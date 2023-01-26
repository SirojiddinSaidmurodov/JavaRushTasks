package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new LinkedList<>();
        int page = 0;
        try {
            while (true) {
                Document document = getDocument(searchString, page);
                Elements vacancies = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (!vacancies.isEmpty())
                    for (Element element : vacancies) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(element.select("[data-qa='vacancy-serp__vacancy-title']").text());
                        vacancy.setUrl(element.select("[data-qa='vacancy-serp__vacancy-title']").attr("href"));
                        vacancy.setCompanyName(element.select("[data-qa='vacancy-serp__vacancy-employer']").text());
                        Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                        vacancy.setSalary(salary.size() > 0 ? salary.get(0).text() : "");
                        vacancy.setCity(element.select("[data-qa='vacancy-serp__vacancy-address']").text());
                        vacancy.setSiteName("hh.ru");
                        result.add(vacancy);
                    }
                else {
                    break;
                }
                page++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
//        return Jsoup.connect("https://javarush.com/testdata/big28data.html")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .referrer("https://hh.ru/")
                .get();
    }
}
