package ${packageName};

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.LoadingBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@IocBy(type=ComboIocProvider.class,args={"*org.nutz.ioc.loader.json.JsonLoader","conf",
	  "*org.nutz.ioc.loader.annotation.AnnotationIocLoader","${packageName}"})
@Encoding(input="utf8",output="utf8")
@Modules(scanPackage=true)
@Localization("msg")
@Ok("json")
@Fail("void")
public class MainModule {
}
