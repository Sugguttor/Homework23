package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final String name;
    private final String text;
    private final UUID id;

    public Article(String name, String text, UUID id) {
        this.name = name;
        this.text = text;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return (name + '\n' + text);
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
