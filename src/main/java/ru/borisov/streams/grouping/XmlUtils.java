package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

class XmlUtils {

    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
        return files.stream()
                .collect(groupingBy(XmlFile::encoding, filtering(
                        xmlFile -> xmlFile.tags().stream()
                                .anyMatch(tag -> tag.name().equals(tagName)),
                        summingLong(xmlFile -> xmlFile.tags().size())
                )));
    }

    public static void main(String[] args) {

        List<XmlFile> xmlFiles = List.of(
                new XmlFile("1", "UTF-8", List.of(new Tag("function"), new Tag("load"))),
                new XmlFile("2", "UTF-8", List.of(new Tag("table"), new Tag("main"))),
                new XmlFile("3", "ASCII", List.of(new Tag("row"), new Tag("column"))),
                new XmlFile("4", "ASCII", List.of(new Tag("sheet"), new Tag("row"))),
                new XmlFile("5", "ASCII", List.of(new Tag("sheet"), new Tag("column"), new Tag("row")))
        );

        Map<String, Long> sheetTagsCount = XmlUtils.countAllByTagName(xmlFiles, "sheet");// returns {"UTF-8"=0, "ASCII"=5}
        System.out.println(sheetTagsCount);
    }
}

record Tag(String name) {
}

record XmlFile(String id, String encoding, List<Tag> tags) {
}
