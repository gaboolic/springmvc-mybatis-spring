package tk.gbl.converter;

import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class DefaultFormatterRegistrar implements FormatterRegistrar {

    public void registerFormatters(FormatterRegistry registry) {
        if (registry instanceof ConversionService) {
            ConversionService service = (ConversionService) registry;

            registry.addConverter(new StringDateConverter());
        }
        // register custom converter.
    }
}
