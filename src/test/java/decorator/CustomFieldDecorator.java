package decorator;

import decorator.elements.base.IElement;
import decorator.utils.LocatingCustomElementListHandler;
import decorator.utils.WrapperFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.*;

import java.lang.reflect.*;
import java.util.List;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<IElement> decoratableClass = decoratableClass(field);

        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            if (List.class.isAssignableFrom(field.getType())) {
                return createList(loader, locator, decoratableClass);
            }
            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }

    private Class<IElement> decoratableClass(Field field) {
        Class<?> clazz = field.getType();
        if (List.class.isAssignableFrom(clazz)) {
            if (field.getAnnotation(FindBy.class) == null && field.getAnnotation(FindBys.class) == null) {
                return null;
            }
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            clazz = (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
        }

        if (IElement.class.isAssignableFrom(clazz)) {
            return (Class<IElement>) clazz;
        } else {
            return null;
        }
    }

    protected IElement createElement(ClassLoader loader, ElementLocator locator, Class<IElement> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return WrapperFactory.createInstance(clazz, proxy);
    }

    protected List<IElement> createList(ClassLoader loader, ElementLocator locator, Class<IElement> clazz) {
        InvocationHandler handler = new LocatingCustomElementListHandler(locator, clazz);
        return (List<IElement>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }
}