package org.cpic;

import org.pharmgkb.parser.vcf.VcfParser;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'Mark' at '4/11/16 12:56 PM' with Gradle 2.12
 *
 * @author Mark, @date 4/11/16 12:56 PM
 */
public class Hello {
  public static void main(String[] args) {

    Path p = Paths.get(args[0]);

    try (BufferedReader reader = Files.newBufferedReader(p)) {
      new VcfParser.Builder()
        .fromReader(reader)
        .parseWith((metadata, position, sampleData) -> {

          System.out.println(position.getChromosome());
          System.out.println(position.getPosition());
          System.out.println(position.getIds());
          System.out.println(position.getRef());
          System.out.println(position.getAltBases());
          System.out.println(position.getQuality());
        })
        .build().parse();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
