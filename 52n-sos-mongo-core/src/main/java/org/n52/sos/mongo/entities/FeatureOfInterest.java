/**
 * Copyright (C) 2013 Christian Autermann
 *
 * This program is free software; you can redistribute and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; even without the implied
 * WARRANTY OF MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program (see gnu-gpl v2.txt). If not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA or
 * visit the Free Software Foundation web page, http://www.fsf.org.
 */
package org.n52.sos.mongo.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.n52.sos.ogc.OGCConstants;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Indexed;
import com.github.jmkgreen.morphia.annotations.Property;
import com.github.jmkgreen.morphia.annotations.Reference;
import com.github.jmkgreen.morphia.utils.IndexDirection;
import com.google.common.base.Objects;
import com.vividsolutions.jts.geom.Geometry;

/**
 * @author Christian Autermann <c.autermann@52north.org>
 */
@Entity
public class FeatureOfInterest extends AbstractEntity {

    public static final String NAMES = "names";
    public static final String DESCRIPTION = "description";
    public static final String XML = "xml";
    public static final String GEOMETRY = "geometry";
    public static final String TYPE = "type";
    public static final String URL = "url";
    public static final String SAMPLED_FEATURES = "sampledFeatures";

    @Id
    private ObjectId id;
    @Indexed
    @Embedded(NAMES)
    private List<Identifier> names;
    @Property(DESCRIPTION)
    private String description;
    @Property(XML)
    private String xmlDescription;
    @Indexed(IndexDirection.GEO2D)
    @Property(GEOMETRY)
    private Geometry geometry;
    @Property(TYPE)
    private String featureType = OGCConstants.UNKNOWN;
    @Indexed
    @Property(URL)
    private String url;
    @Indexed
    @Reference(value = SAMPLED_FEATURES, lazy = true)
    private List<FeatureOfInterest> sampledFeatures;

    public ObjectId getId() {
        return id;
    }

    public FeatureOfInterest setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public List<Identifier> getNames() {
        return names;
    }

    public FeatureOfInterest setNames(List<Identifier> names) {
        this.names = names;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FeatureOfInterest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getXmlDescription() {
        return xmlDescription;
    }

    public FeatureOfInterest setXmlDescription(String xmlDescription) {
        this.xmlDescription = xmlDescription;
        return this;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public FeatureOfInterest setGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }

    public String getFeatureType() {
        return featureType;
    }

    public FeatureOfInterest setFeatureType(String featureType) {
        this.featureType = featureType;
        return this;

    }

    public String getUrl() {
        return url;
    }

    public FeatureOfInterest setUrl(String url) {
        this.url = url;
        return this;
    }

    public List<FeatureOfInterest> getSampledFeatures() {
        return sampledFeatures;
    }

    public FeatureOfInterest setSampledFeatures(List<FeatureOfInterest> sampledFeatures) {
        this.sampledFeatures = sampledFeatures;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(),
                                getNames(),
                                getDescription(),
                                getXmlDescription(),
                                getGeometry(),
                                getFeatureType(),
                                getUrl(),
                                getSampledFeatures());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof FeatureOfInterest) {
            FeatureOfInterest o = (FeatureOfInterest) obj;
            return Objects.equal(getId(), o.getId())
                   && Objects.equal(getDescription(), o.getDescription())
                   && Objects.equal(getFeatureType(), o.getFeatureType())
                   && Objects.equal(getGeometry(), o.getGeometry())
                   && Objects.equal(getNames(), o.getNames())
                   && Objects.equal(getSampledFeatures(), o.getSampledFeatures())
                   && Objects.equal(getUrl(), o.getUrl())
                   && Objects.equal(getXmlDescription(), o.getXmlDescription());
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(getClass())
                .add("id", getId())
                .add("names", getNames())
                .add("geom", getGeometry())
                .toString();
    }
    
    
}
