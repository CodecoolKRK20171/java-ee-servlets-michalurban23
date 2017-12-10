package com.michalurban;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CharacterCreator", urlPatterns = "/create")
public class CharacterCreator extends HttpServlet {

    private Character character = new Character();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StringBuilder pageContent = new StringBuilder();

        pageContent.append(CommonHtml.getTopHtml("Creator"));
        pageContent.append(getForm());
        pageContent.append(CommonHtml.getBottomHtml());

        response.getWriter().write(pageContent.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> characterData = request.getParameterMap();
        character.setupCharacter(characterData);

        StringBuilder pageContent = new StringBuilder();

        pageContent.append(CommonHtml.getTopHtml("Character Sheet"));
        pageContent.append(createSheet());
        pageContent.append(CommonHtml.getBottomHtml());

        response.getWriter().write(pageContent.toString());
    }

    private String getForm() {

        return "<form method=\"POST\">" +
                "<fieldset>" +
                "<legend>Please fill all required fields</legend>" +
                "<label for=\"name\">Your name:</label>" +
                "<input id=\"name\" name=\"name\" type=\"text\" required /><br />" +
                "<label for=\"race\">Are you:</label>" +
                "<input name=\"race\" type=\"radio\" value=\"pretty\" required />Insanely Good Looking<br/>" +
                "<input name=\"race\" type=\"radio\" value=\"ugly\" required />Ugly As A Busted Arse<br/>" +
                "<input name=\"race\" type=\"radio\" value=\"normal\" required />Distinctively Average<br/>" +
                "<label for=\"gender\">Gender:</label>" +
                "<input name=\"gender\" type=\"radio\" value=\"Male\" required />Manly Man<br/>" +
                "<input name=\"gender\" type=\"radio\" value=\"Female\" required />Womanly Woman<br/>" +
                "<label for=\"role\">You prefer:</label>" +
                "<input name=\"role\" type=\"radio\" value=\"melee\" required />Smashing Skulls<br/>" +
                "<input name=\"role\" type=\"radio\" value=\"ranged\" required />Throwing Stuff<br/>" +
                "<input name=\"role\" type=\"radio\" value=\"spec\" required />Waving Wand<br/>" +
                "<input name=\"role\" type=\"radio\" value=\"support\" required />Singing Rites<br/>" +
                "<label for=\"alignment1\">When you meet an old lady in a need of help:</label>" +
                "<input name=\"alignment1\" type=\"radio\" value=\"good\" required />Obviously Help<br/>" +
                "<input name=\"alignment1\" type=\"radio\" value=\"neutral\" required />Sympathize<br/>" +
                "<input name=\"alignment1\" type=\"radio\" value=\"evil\" required />Tell Her To Get Lost<br/>" +
                "<label for=\"alignment2\">When you find lost wallet on the street:</label>" +
                "<input name=\"alignment2\" type=\"radio\" value=\"lawful\" required />Bring It To Police Station<br/>" +
                "<input name=\"alignment2\" type=\"radio\" value=\"neutral\" required />Personally Return To Owner<br/>" +
                "<input name=\"alignment2\" type=\"radio\" value=\"chaotic\" required />Take The Money<br/>" +
                "<label for=\"stats1\">Your tend to get out of trouble using:</label>" +
                "Physical Strength<input name=\"stats1\" type=\"range\" min=\"4\" max=\"18\" step=\"2\" required />Conversation<br/>" +
                "<label for=\"stats2\">When solving problems you rely on:</label>" +
                "Intuition<input name=\"stats2\" type=\"range\" min=\"4\" max=\"18\" step=\"2\" required />Logic<br/>" +
                "<label for=\"stats3\">You're more likely to play</label>" +
                "Table Tennis<input name=\"stats3\" type=\"range\" min=\"4\" max=\"18\" step=\"2\" required />Football<br/>" +
                "<input type=\"submit\" value=\"Create\" />" +
                "</fieldset>" +
                "</form>";
    }

    private String createSheet() throws IOException {

        return character.getAlignment();
    }

}