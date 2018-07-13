package org.icij.datashare.cli;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

public class DatashareCliTest {
    @Test
    public void test_web_opt() {
        DatashareCli.parseArguments(new String[] {"-o"});
        assertThat(DatashareCli.webServer).isFalse();

        DatashareCli.parseArguments(new String[] {"--web"});
        assertThat(DatashareCli.webServer).isTrue();

        DatashareCli.parseArguments(new String[] {"-w"});
        assertThat(DatashareCli.webServer).isTrue();
    }

    @Test
    public void test_mode_opt() {
        DatashareCli.parseArguments(new String[] {""});
        assertThat(DatashareCli.properties).includes(entry("mode", "LOCAL"));

        DatashareCli.parseArguments(new String[] {"--mode=PRODUCTION"});
        assertThat(DatashareCli.properties).includes(entry("mode", "PRODUCTION"));
    }
}