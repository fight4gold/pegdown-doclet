/*
 * Copyright 2013 Raffael Herzog
 *
 * This file is part of pegdown-doclet.
 *
 * pegdown-doclet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pegdown-doclet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with pegdown-doclet.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.raffael.doclets.pegdown;

import com.sun.javadoc.ParamTag;

import static ch.raffael.doclets.pegdown.TagRendering.*;


/**
 * Renderer for `@param` tags.
 *
 * @author <a href="mailto:herzog@raffael.ch">Raffael Herzog</a>
 */
public class ParamTagRenderer implements TagRenderer<ParamTag> {

    public static final ParamTagRenderer INSTANCE = new ParamTagRenderer();

    @Override
    public void render(ParamTag tag, StringBuilder target, PegdownDoclet doclet) {
        target.append(tag.name())
                .append(' ').append(renderParameterName(tag))
                .append(' ').append(simplifySingleParagraph(doclet.toHtml(tag.parameterComment())));
    }

    private static String renderParameterName(ParamTag tag) {
        if (!tag.isTypeParameter()) {
            return tag.parameterName();
        }
        else {
            return '<' + tag.parameterName() + '>';
        }
    }
}
