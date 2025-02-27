package logic;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationTests {

	/**
	 * 生成AsciiDocs格式文档
	 * @throws Exception
	 */
	@Test
	public void generateAsciiDocs() throws Exception {
		//    输出Ascii格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)//设置生成格式
				.withOutputLanguage(Language.ZH)//设置语言中文还是其他语言
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();
		//设置swagger-api的json来源
		Swagger2MarkupConverter.from(new URL("http://DESKTOP-36MV4LQ:8080/yst-api/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("./docs/asciidoc/generated"));//设置生成文件的路径
	}

	/**
	 * 生成Markdown格式文档
	 * @throws Exception
	 */
	@Test
	public void generateMarkdownDocs() throws Exception {
		//    输出Markdown格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.MARKDOWN)
				.withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();

		Swagger2MarkupConverter.from(new URL("http://DESKTOP-36MV4LQ:8080/yst-api/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("./docs/markdown/generated"));
	}
	/**
	 * 生成Confluence格式文档
	 * @throws Exception
	 */
	@Test
	public void generateConfluenceDocs() throws Exception {
		//    输出Confluence使用的格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
				.withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();

		Swagger2MarkupConverter.from(new URL("http://DESKTOP-36MV4LQ:8080/yst-api/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("./docs/confluence/generated"));
	}

	/**
	 * 生成AsciiDocs格式文档,并汇总成一个文件
	 * @throws Exception
	 */
	@Test
	public void generateAsciiDocsToFile() throws Exception {
		//    输出Ascii到单文件
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();

		Swagger2MarkupConverter.from(new URL("http://DESKTOP-36MV4LQ:8080/yst-api/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFile(Paths.get("./docs/asciidoc/generated/all"));
	}

	/**
	 * 生成Markdown格式文档,并汇总成一个文件
	 * @throws Exception
	 */
	@Test
	public void generateMarkdownDocsToFile() throws Exception {
		//    输出Markdown到单文件
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.MARKDOWN)
				.withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema()
				.build();

		Swagger2MarkupConverter.from(new URL("http://DESKTOP-36MV4LQ:8080/yst-api/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFile(Paths.get("./docs/markdown/generated/all"));
	}
}
